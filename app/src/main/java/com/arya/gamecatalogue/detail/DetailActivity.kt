package com.arya.gamecatalogue.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.arya.gamecatalogue.R
import com.arya.gamecatalogue.core.domain.model.Game
import com.arya.gamecatalogue.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailTourism = intent.getParcelableExtra<Game>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(game: Game?) {
        game?.let {
            supportActionBar?.title = game.name
            binding.tvDetailReleaseDate.text = game.released
            binding.tvDetailPlaytime.text = "AVERAGE PLAYTIME: ${game.playtime}"
            binding.tvDetailName.text = game.name
            binding.tvDetailRating.text = game.rating.toString()
            binding.tvDetailPlatform.text = game.platforms.joinToString(", ")
            binding.tvDetailGenres.text = game.genres.joinToString(", ")
            binding.tvDetailEsrb.text = game.esrbRating
            binding.tvDetailMetacritic.text = game.metacritic.toString()
            Glide.with(this@DetailActivity)
                .load(game.backgroundImage)
                .into(binding.ivDetailImage)

            var statusFavorite = game.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteGame(game, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
        }
    }
}