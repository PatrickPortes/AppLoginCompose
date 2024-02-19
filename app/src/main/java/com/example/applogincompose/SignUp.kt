package com.example.applogincompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.applogincompose.navigation.Screen
import com.example.applogincompose.ui.theme.AppLoginComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            text = "Welcome to Our Platform!",
            style = TextStyle(
                fontSize = 50.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                lineBreak = LineBreak.Paragraph
            )
        )

        Spacer(modifier = Modifier.height(50.dp))

        //Character Count Limit on Text Field:
        val maxCharEmail = 50
        val maxCharPassword = 30
        val maxCharUsername = 50

        //UserName TextField:
        var name by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            value = name,
            onValueChange = {
                if (it.length <= maxCharUsername) {
                    name = it
                }
            },
            placeholder = { Text(text = "Username") },
            label = { Text(text = "Username") },
            singleLine = true,
            maxLines = 1,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Person Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.None
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Email Text Field:
        var email by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            value = email,
            onValueChange = {
                if (it.length <= maxCharEmail) {
                    email = it
                }
            },
            placeholder = { Text(text = "Email") },
            label = { Text(text = "Email") },
            singleLine = true,
            maxLines = 1,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.None
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Password Text Field:
        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }

        val icon = if (passwordVisibility) {
            painterResource(id = R.drawable.baseline_visibility_24)
        } else {
            painterResource(id = R.drawable.baseline_visibility_off_24)
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            value = password,
            onValueChange = {
                if (it.length <= maxCharPassword) {
                    password = it
                }
            },
            singleLine = true,
            maxLines = 1,
            placeholder = { Text(text = "Password") },
            label = { Text(text = "Password") },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Password Icon"
                    )
                }
            },
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                capitalization = KeyboardCapitalization.None,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        var passwordConfirmation by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            value = passwordConfirmation,
            onValueChange = {
                if (it.length <= maxCharPassword) {
                    passwordConfirmation = it
                }
            },
            singleLine = true,
            maxLines = 1,
            placeholder = { Text(text = "Confirm Password") },
            label = { Text(text = "Confirm Password") },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Password Icon"
                    )
                }
            },
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                capitalization = KeyboardCapitalization.None,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        //Button Login

        Button(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            onClick = {

                if (name.isNotEmpty()) {

                    if (validateEmail(email)) {

                        if (password.isNotEmpty()) {

                            if (validatePassword(password)) {

                                if (passwordConfirmation.isNotEmpty()) {

                                    if (password == passwordConfirmation) {

                                        navController.popBackStack()
                                        showToast(context, "Account Created Successfully!")
                                        navController.navigate(Screen.HomeScreen.route)

                                    } else {
                                        showToast(context, "Your Password Confirmation Needs to be the same!")
                                    }
                                } else {
                                    showToast(context, "Confirm Your Password Please!")
                                }
                            } else {
                                showToast(context, "Needs to contain at least one uppercase letter and one number")
                            }
                        } else {
                            showToast(context, "Invalid Password!")
                        }
                    } else {
                        showToast(context, "Invalid Email!")
                    }
                } else {
                    showToast(context, "Enter an Username Please!")
                }

            },
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        ) {
            Text(text = "SIGN UP")
        }

        Spacer(modifier = Modifier.height(30.dp))

        //Login Methods
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                color = Color.Gray,
                thickness = 2.dp,
                modifier = Modifier
                    .width(40.dp)
                    .padding(end = 5.dp)
            )
            Text(text = "Or Sign Up With")
            Divider(
                color = Color.Gray,
                thickness = 2.dp,
                modifier = Modifier
                    .width(40.dp)
                    .padding(start = 5.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            LoginButton(imageId = R.drawable.google_logo, onClick = {
                showToast(context, "Login With Google Account!")
            })
            Spacer(modifier = Modifier.width(8.dp))
            LoginButton(imageId = R.drawable.facebook_logo, onClick = {
                showToast(context, "Login With Facebook Account!")
            })
            Spacer(modifier = Modifier.width(8.dp))
            LoginButton(imageId = R.drawable.linkedin_logo, onClick = {
                showToast(context, "Login With LinkedIn Account!")
            })
        }

        Spacer(modifier = Modifier.height(40.dp))

        //SignUp Text/Button

        Text(
            text = "Already Have an Account?",
            modifier = Modifier
                .padding(3.dp)
                .wrapContentSize(Alignment.Center)
        )
        Text(
            text = "Sign In",
            style = TextStyle(color = Color.Blue, fontSize = 15.sp),
            modifier = Modifier
                .padding(3.dp, end = 10.dp)
                .clickable {
                    navController.navigate(Screen.SignInScreen.route)
                }
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.height(15.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    AppLoginComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SignUpScreen(rememberNavController())
        }
    }
}