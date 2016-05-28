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

## Problem I'm struggling with:

The intended behavior of the app should be the following:

root component is `App`, it contains two main components - `TopNavBar` and `UiContainer`. Whenever item in navbar's menu gets selected - it triggers mutation on `:app/current-route`, which basically is a vector of keys - IDs of selected main menu and sub-menu items. 

When the route-changes, it should trigger `update-root-queries`, which matches given route with a component using `route->component` (right now it's just a single `LedgerAccountIndexRoot`). So, it retrieves the component, grabs its queries and then in `update-root-queries` uses `om/set-query!` to update query of `UiContainer`, 

that should trigger fetching hosted component's data, since `App` component has a join query that points to UiContainer (it's commented out right now and breaks everything when uncommmented)
