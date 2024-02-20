package com.example.capitales.countryDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Surface
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.capitales.Country
import com.example.capitales.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CountryDetailScreen() {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.secondary_background))
            .padding(start = 8.dp, end = 8.dp, bottom = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        CountryInformation(country)// aca hay q pasarle el COUNTRY
        Image(
            modifier = Modifier
                .width(270.dp)
                .padding(top = 80.dp),
            painter = rememberImagePainter(country.flags.png),
            contentDescription = country.name
        )
    FloatingActionButton(
        modifier = Modifier.align(alignment = Alignment.BottomCenter),
        onClick = { }
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = ""
        )
        
    }    
    }
}

//CON CTRL + P, PODEMOS VER CUALES SON LOS ATRIBUTOS QUE PODEMOS PONER DEPENDIENDO EL VIEW QUE TENGAMOS!!!!!
@Composable
fun CountryInformation(country: Country) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 180.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            color = colorResource(id = android.R.color.white)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.population, country.population),
                    fontSize = 32.sp,
                    color = colorResource(id = R.color.text_black),
                    textAlign = TextAlign.End

                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, bottom = 8.dp, start = 8.dp, end = 8.dp),
                    text = stringResource(R.string.country),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Medium

                )

                Text(
                    stringResource(id = R.string.population, country.population),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.text_black)
                )
                Text(
                    stringResource(id = R.string.area, country.area),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.text_black),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Divider( //ESTA ES LA RAYA QUE DIVIDE HORIZONTAL
                    modifier = Modifier
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 16.dp),
                    color = colorResource(id = R.color.divider),
                    thickness = 1.dp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    CountryDataColumn(
                        Modifier.weight(1f),
                        country.region,
                        country.continents
                    )

                    verticalDivider()
                    Column( //CREO LAS 3 COLUMNAS INFERIORES
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.borders),
                            textAlign = TextAlign.Center,
                            color = colorResource(id = R.color.dark_gray),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.borders),
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.text_black),
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                    }

                    verticalDivider()

                    CountryDataColumn(
                        modifier = Modifier.weight(1f),
                        country.fifa,
                        country.translations.spa
                    )

                }
            }
        }
    }
}

@Composable
private fun CountryDataColumn(
    modifier: Modifier = Modifier,
    description1: String,
    description2: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.region),
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.dark_gray),
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(id = R.string.region),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_black),
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(id = R.string.continents),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = colorResource(id = R.color.dark_gray),
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(id = R.string.continents),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_black),
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 8.dp)
        )

    }
}

@Composable
private fun verticalDivider() {
    Divider(
        modifier = Modifier
            .height(42.dp)
            .width(1.dp)
    )
}

@Preview
@Composable
fun CountryDetailScreenPreview() {
    CountryDetailScreen()
}