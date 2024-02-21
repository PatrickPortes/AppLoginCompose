package com.example.applogincompose.compose

import android.content.res.Configuration
import android.util.Log
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.applogincompose.R
import com.example.applogincompose.UserViewModel
import com.example.applogincompose.navigation.Navigation
import com.example.applogincompose.navigation.Screen
import com.example.applogincompose.ui.theme.AppLoginComposeTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(navController: NavController) {

    val context = LocalContext.current

    val viewModel = hiltViewModel<UserViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

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
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = if (passwordVisibility) "Hide Password" else "Show Password",
                        tint = Color.Gray
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

        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            verticalAlignment = Alignment.CenterVertically
        ) {

            var checked by remember { mutableStateOf(true) }

            val customColors = CheckboxDefaults.colors(
                checkedColor = Color.Black, // Change the checked color
                uncheckedColor = Color.Gray, // Change the unchecked color
                checkmarkColor = Color.White // Change the checkmark color
            )

            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = customColors
            )

            Text(
                text = "Remember me",
                style = TextStyle(
                    fontSize = 15.sp
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp)
            )

            Text(
                text = "Forgot Password?",
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Blue,
                    textAlign = TextAlign.End
                ),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(end = 10.dp)
                    .clickable {
                        showToast(context, "Recovering Password!")
                    }
            )

        }

        Spacer(modifier = Modifier.height(8.dp))

        //Button Login

        Button(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            onClick = {

                if (email.isNotEmpty()) {
                    if (password.isNotEmpty()) {

                        viewModel.viewModelScope.launch {
                            val isAuthenticated = viewModel.authenticateUser(email, password)
                            if (isAuthenticated) {

                                //Login Successful:
                                showToast(context, "SignIn Successfully!")
                                Log.i("MyTag", "User SignIn Successfully: Email: $email \n Password: $password")
                                navController.popBackStack()
                                navController.navigate(Screen.HomeScreen.route)

                            } else {
                                //Login Invalid:
                                showToast(context, "Invalid Email or Password!")
                            }
                        }

                    } else {
                        showToast(context, "Enter an Password!")
                    }
                } else {
                    showToast(context, "Enter an Email!")
                }

            },
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        ) {
            Text(text = "LOGIN")
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
            Text(text = "Or Login With")
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

        Spacer(modifier = Modifier.height(60.dp))

        //SignUp Text/Button

        Text(
            text = "New User?",
            modifier = Modifier
                .padding(3.dp)
                .wrapContentSize(Alignment.Center)
        )
        Text(
            text = "Sign Up",
            style = TextStyle(color = Color.Blue, fontSize = 15.sp),
            modifier = Modifier
                .padding(3.dp, end = 10.dp)
                .clickable {
                    navController.navigate(Screen.SignUpScreen.route)
                }
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.height(15.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreviewDayMode() {
    AppLoginComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SignInScreen(rememberNavController())
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SignInScreenPreviewNightMode() {
    AppLoginComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SignInScreen(rememberNavController())
        }
    }
}