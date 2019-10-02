package com.example.passenger.ui.fragments


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.passenger.R
import com.example.passenger.utils.toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.ByteArrayOutputStream


class ProfileFragment : Fragment() {

    private val DEFAULT_IMAGE_URL = "http://picsum.photos/200"

    private lateinit var imageUri: Uri

    private val REQUEST_IMAGE_CAPTURE = 100    //request code to identify the intent

    private val currentUser = FirebaseAuth.getInstance().currentUser //get the current user


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentUser?.let { user ->
            Glide.with(this)
                .load(user.photoUrl)
                .into(image_view)

            edit_text_name.setText(user.displayName)

            text_email.text = user.email
            text_phone.text =
                if (user.phoneNumber.isNullOrEmpty()) "Add Number" else user.phoneNumber

            if (user.isEmailVerified) {
                text_not_verified.visibility = View.INVISIBLE
            } else {
                text_not_verified.visibility = View.VISIBLE
            }
        }
        //image view click event
        image_view.setOnClickListener {
            takePictureIntent()
        }

        button_save.setOnClickListener {
            val photo = when {
                ::imageUri.isInitialized -> imageUri
                currentUser?.photoUrl == null -> Uri.parse(DEFAULT_IMAGE_URL)
                else -> currentUser.photoUrl
            }
            val name = edit_text_name.text.toString().trim()

            if (name.isEmpty()) {
                edit_text_name.error = "name required"
                edit_text_name.requestFocus()
                return@setOnClickListener
            }

            val updates = UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .setPhotoUri(photo)
                .build()

            progressbar.visibility = View.VISIBLE

            currentUser?.updateProfile(updates)
                ?.addOnCompleteListener { task ->
                    progressbar.visibility = View.INVISIBLE
                    if (task.isSuccessful) {
                        context?.toast("Profile Updated")
                    } else {
                        context?.toast(task.exception?.message!!)
                    }
                }
        }
        text_not_verified.setOnClickListener {
            currentUser?.sendEmailVerification()
                ?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        context?.toast("verification Email is Sent")
                    } else {
                        context?.toast(it.exception?.message!!)
                    }
                }
        }
        text_phone.setOnClickListener {
            val action = ProfileFragmentDirections.actionVerifyPhone()
            Navigation.findNavController(it).navigate(action)
        }

        text_email.setOnClickListener {
            val action = ProfileFragmentDirections.actionUpdateEmail()
            Navigation.findNavController(it).navigate(action)
        }

        text_password.setOnClickListener {
            val action = ProfileFragmentDirections.actionUpdatePassword()
            Navigation.findNavController(it).navigate(action)
        }
    }

    //capture the photo
    private fun takePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { pictureIntent ->
            pictureIntent.resolveActivity(activity?.packageManager!!)?.also {
                //get the best activity to handle the intent
                startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    //receive the result from the child activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap  // receive the image as a bitmap
            uploadImageAndSaveUri(imageBitmap)
        }
    }

    private fun uploadImageAndSaveUri(imageBitmap: Bitmap) {
        val baos = ByteArrayOutputStream()  //output stream which data is written in to bytes
        val storageRef = FirebaseStorage.getInstance()
            .reference
            .child("pics/${FirebaseAuth.getInstance().currentUser?.uid}")

        imageBitmap.compress(
            Bitmap.CompressFormat.JPEG,
            100,
            baos
        )  //write a compressed version of the bitmap
        val image = baos.toByteArray() //data is retrieved

        val upload = storageRef.putBytes(image)
        progressbar_pic.visibility = View.VISIBLE   //set progress bar
        upload.addOnCompleteListener { uploadTask ->
            progressbar_pic.visibility = View.INVISIBLE  //remove progress bar
            if (uploadTask.isSuccessful) {
                storageRef.downloadUrl.addOnCompleteListener { urlTask ->
                    urlTask.result?.let {
                        imageUri = it
                        image_view.setImageBitmap(imageBitmap) //display the image
                    }
                }
            } else {
                uploadTask.exception?.let {
                    activity?.toast(it.message!!) // show the error message
                }
            }
        }
    }

}
