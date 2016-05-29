This is a very basic app built with Om Next
while I was learning Om Next

## Dependencies
- node & npm
- gems:
    `gem install sass`
    `gem install sass-globbing`

## Interactive Development
Start `lein repl`.
From the repl, call `(start)` to start the server,
and `(repl)` to start the cljs repl.
Open your browser to http://localhost:3333.
You can `(restart)` the server from the repl when you make changes to server code.
The client code will be automagically reloaded for you.
Try refreshing your browser page if the cljs reloading is having problems.

The repl might not work if you run it from inside your editor;
you can connect to the running repl instead.
e.g. cider-connect -> localhost -> om-basic-app:7001
