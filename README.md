
# FizzBuzz App

Generating FizzBuzz based on user's inputs


## Documentation

This application presents a form where user selects the input of his choice and generate a fizz buzz list.
Application architecture is based on MVVM, even though its implementation is limited.

Application uses a viewModel form managing data inputs and generate a list of string based on fizzbuzz model.

Application uses a recyclerview. Recyclerview has the best memory management for this kind of list, avoiding generat the whole list of strings, and recycling cells during user scrolling.

