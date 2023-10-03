package com.example.pracricaformulario.ui.pantallaMain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.pracricaformulario.databinding.ActivityMainBinding
import com.example.pracricaformulario.domain.usecases.review.AddReviewUseCase
import com.example.pracricaformulario.domain.usecases.review.GetReview
import com.example.pracricaformulario.utils.StringProvider

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels{
        MainViewModelFactory(
            StringProvider.instances(this),
            AddReviewUseCase(),
            GetReview(),
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        observarViewModel()

    }

    private fun observarViewModel() {
        viewModel.uiState.observe(this@MainActivity) { state ->
            state.mensaje?.let { mensaje ->
                Toast.makeText(this@MainActivity, mensaje, Toast.LENGTH_SHORT).show()
                viewModel.mensajeMostrado()
            }
        }
    }
}