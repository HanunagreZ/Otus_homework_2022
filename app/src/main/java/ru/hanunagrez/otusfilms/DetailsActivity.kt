package ru.hanunagrez.otusfilms

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.hanunagrez.otusfilms.databinding.ActivityDetailsBinding


class DetailsActivity : AppCompatActivity() {
    lateinit var detailsBinding: ActivityDetailsBinding

    var likeOrNot = false

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(detailsBinding.root)

        if(savedInstanceState != null){
            likeOrNot = savedInstanceState.getBoolean(BUNDLE_LIKE)
        }

        val textAboutFilm = intent.getStringExtra("text")
        val imageId = intent.getIntExtra("imageId", 0)
        likeOrNot = intent.getBooleanExtra("like", false)
        if (likeOrNot){
            detailsBinding.switchFavorites.toggle()
        }

        detailsBinding.tvFilmInfo.text = textAboutFilm
        detailsBinding.imageView.setImageResource(imageId)

        detailsBinding.btSendComment.setOnClickListener {
            val intent = Intent()
            intent.putExtra("textComment", detailsBinding.edTComment.text.toString())
            intent.putExtra(SEND_BOOLEAN, likeOrNot)
            setResult(RESULT_OK, intent)
            finish()
        }

        detailsBinding.switchFavorites?.setOnCheckedChangeListener { _, _ ->
            likeOrNot = !likeOrNot
        }

        detailsBinding.btShareFriends.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setData(Uri.parse("https://web.telegram.org/"))
            }
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(BUNDLE_LIKE, likeOrNot)
    }

    companion object {
        const val SEND_BOOLEAN = "favorite"
        const val BUNDLE_LIKE = "bundle"
    }

}

