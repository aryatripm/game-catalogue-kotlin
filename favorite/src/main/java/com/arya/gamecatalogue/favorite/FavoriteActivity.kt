package com.arya.gamecatalogue.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.arya.gamecatalogue.core.data.Resource
import com.arya.gamecatalogue.core.ui.GameAdapter
import com.arya.gamecatalogue.di.FavoriteModuleDependencies
import com.arya.gamecatalogue.favorite.databinding.ActivityFavoriteBinding
import com.arya.gamecatalogue.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels { factory }
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameAdapter = GameAdapter()
        gameAdapter.onItemClick = { }

        favoriteViewModel.favoriteGames.observe(this) {
            if (it != null) {
                gameAdapter.setData(it)
                with(binding.rvTourism) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = gameAdapter
                }
            }
        }
    }
}