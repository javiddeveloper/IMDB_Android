package ir.javid.developer.imdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.javid.developer.imdb.R
import ir.javid.developer.imdb.ui.listMovie.ListMovieFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, ListMovieFragment.newInstance())
            .commit()
    }
}
