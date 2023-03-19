package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.Hero
import com.example.superheroes.data.HeroesRepository.heroes
import com.example.superheroes.ui.theme.SuperheroesTheme


@Composable
fun HeroApp() {
    Scaffold(
        topBar = {
            HeroTopAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            items(heroes) {
                HeroItem(hero = it)
            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {

    Card(
        elevation = 2.dp,
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16))
    ) {

        Row(
            modifier = Modifier.height(80.dp)
        ) {
            Box(

                modifier = Modifier
                    .weight(7f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp, 16.dp, 16.dp, 16.dp)
                ) {
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        HeroName(hero.nameRes)
                    }

                    Box(modifier = Modifier.weight(1f)) {
                        HeroDescription(hero.descriptionRes)
                    }

                }
            }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
                    .padding(8.dp),

                ) {
                HeroIcon(hero.imageRes)
            }
        }
    }
}

@Composable
fun HeroIcon(@DrawableRes heroIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(64.dp)
            .clip(RoundedCornerShape(8)),
        painter = painterResource(heroIcon),
        contentDescription = null
    )
}

@Composable
fun HeroName(@StringRes heroName: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(heroName),
        style = MaterialTheme.typography.h3
    )
}

@Composable
fun HeroDescription(@StringRes heroDescription: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(heroDescription),
        style = MaterialTheme.typography.body1
    )
}

@Composable

fun HeroTopAppBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background),
//        verticalAlignment = Alignment.CenterVertically
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@Preview
@Composable
fun HeroPreview() {
    SuperheroesTheme(darkTheme = false) {
        HeroApp()
    }
}