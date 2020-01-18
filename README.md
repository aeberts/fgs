# Fulcro Getting Started

A [fulcro](http://book.fulcrologic.com/#_getting_started) application based on the "getting started" section from the fulcro 3 book.

## Development Mode

### Install the dependencies:

Java SE Development Kit (JDK)

[Clojure Command Line Tools](https://clojure.org/guides/getting_started)

[Node and npm](https://nodejs.org/en/)

### Install Additional Dev Tools

Install the [Fulcro Inspect Plugin for Chrome](https://chrome.google.com/webstore/detail/fulcro-inspect/meeijplnfjcihnhkpanepcaffklobaal)

### Run the application:

```
npx shadow-cljs server
```

Wait a bit, then browse to the shadow-cljs build server (usually http://localhost:9630).

Click `Builds` -> `:main` and shadow-cljs will build your application.  

Shadow-cljs also has hot-code (and CSS) reload built in, so there is no need for any additional tools.

Shadow-cljs will start a development mode HTTP server to serve our HTML file and javascript (usually on http://localhost:8000)  

### Intellij Idea REPL Setup

In the Intellij interface choose "edit configurations"

- Click the 'plus' button in the upper left portion of the screen.
- Choose 'Clojure REPL' -> 'Remote REPL'
- Name your REPL
- For 'Connection Type' choose 'nREPL'
- For 'Connection details' section:
    - for Host use `localhost`
    - for port use the port that was displayed in the terminal when you started the shadow-cljs server. (e.g. if the output in the terminal is `shadow-cljs - nREPL server started on port 9000` then use `9000`).
- Make sure that your application is running and navigate to the application url (probably http://localhost:8000)
- After you start the REPL type: `(shadow/repl :main)` into the REPL input area and shadow-cljs will connect to the application that is running the browser.
- To test if you have a valid connection type: `(js/alert "Hi")** into the REPL input area and you should see an alert pop up in your browser.

### Cider nREPL Setup

(TBD)


## Production Build

(TBD)
