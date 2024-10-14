package com.example.lazyhorizontalgridlazyverticalgrid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : ComponentActivity() {

    private val list = listOf(
        R.drawable.apple,
        R.drawable.avokado,
        R.drawable.cherry,
        R.drawable.lemon,
        R.drawable.mango,
        R.drawable.orange,
        R.drawable.peach,
        R.drawable.pineapple,
        R.drawable.pomegranate,
        R.drawable.strawberry
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var i = 0
            val random = Random
            val newList = mutableListOf<Int>()
            while( i <= 100){
                newList.add(list[random.nextInt(0..9)])
                i++
        }
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp, start = 5.dp, end = 5.dp)
                    .background(Color.Cyan),
                horizontalArrangement = Arrangement.Center
                ) {
                items(newList){item ->
                    Column(
                        modifier = Modifier
                            .padding(4.dp)

                    ) {
                        Image(
                            painter = painterResource(id = item),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(150.dp)
                        )

                    }

                }

            }

            for(j in newList.indices){
                if (j % 3 == 0 && j != 99) {
                    if (newList[j] == newList[j + 1] && newList[j] == newList[j + 2]) {
                        Toast.makeText(this, "Поздравляем! Есть совпадения!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }

}

