# Hangman Game

### How to compile and run the application

The application can be run using the `gradlew bootRun` command inside the repository root directory.

### How to play the game

To play the game, you should first create a new game, making a POST call to the endpoint `/game`.
This call doesn't expect any parameters and returns a JSON in the following format:

`{
"id": 1,
"word": {
"alreadyGuessedWord": "_________"
}
}`

The `alreadyGuessedWord` field value has as many `_` characters as the size of the word to be guessed.

After that, to make guesses of the word's letters, you need to make PUT requests to the endpoint `/game`. This call should have a body in the following format:

`{
"game": {
"id": 1
},
"letter": "E"
}`

The response will return the same data of the POST request, replacing the positions of the word that have the guessed letter with the letter.

`
{
"id": 1,
"word": {
"alreadyGuessedWord": "___E_____"
}
}`