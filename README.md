# primenumbers
Simple Android App to Generate a List of PrimeNumbers

# RUN
- Clone Repo
- Open project in Android Studio
- Run the project. Select either a connected device or Virtual device to run the project on
- There are no external dependencies

# Tests
- 1 Test added
- From Android Studio, right click on PrimeNumbersTest and click on Run 'PrimeNumbersTest'

# Notes/Improvements
- Textview does not scroll horizontally
- Use TableView to present results but TableView does not work with list adapters
  - I Could 
    - Ditch the List Adapter approach and render entire result from the async task as a TableView
    - Create a custom view and view group to render results as tiles

