import 'package:flutter/material.dart';
import 'package:car_rental_app/auth_service.dart';

class SignInSignUpPage extends StatefulWidget {
  @override
  _SignInSignUpPageState createState() => _SignInSignUpPageState();
}

class _SignInSignUpPageState extends State<SignInSignUpPage> {
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();
  String _username, _password;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Sign In / Sign Up"),
      ),
      body: Center(
        child: SingleChildScrollView(
          child: Form(
            key: _formKey,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 16.0),
                  child: TextFormField(
                    decoration: InputDecoration(
                      labelText: "Username",
                      hintText: "Enter your username",
                    ),
                    validator: (input) {
                      if (input.isEmpty) {
                        return "Please enter a username";
                      }
                      return null;
                    },
                    onSaved: (input) => _username = input,
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 16.0),
                  child: TextFormField(
                    obscureText: true,
                    decoration: InputDecoration(
                      labelText: "Password",
                      hintText: "Enter your password",
                    ),
                    validator: (input) {
                      if (input.isEmpty) {
                        return "Please enter a password";
                      }
                      return null;
                    },
                    onSaved: (input) => _password = input,
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                ElevatedButton(
                  onPressed: signIn,
                  child: Text("Sign In"),
                ),
                SizedBox(
                  height: 20,
                ),
                ElevatedButton(
                  onPressed: signUp,
                  child: Text("Sign Up"),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  void signIn() async {
    if (_formKey.currentState.validate()) {
      _formKey.currentState.save();
      AuthService authService = new AuthService();
      var success = await authService.signIn(_username, _password);
      if (success) {
        // Navigate to home page
      } else {
        // Show error message
      }
    }
  }

  void signUp() async {
    if (_formKey.currentState.validate()) {
      _formKey.currentState.save();
      AuthService authService = new AuthService();
      var success = await authService.signUp(_username, _password);
      if (success) {
        // Navigate to home page
      } else {
        // Show error message
      }
    }
  }
}
