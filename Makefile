browse:
	open http://localhost:3333

sass:
	sass -r sass-globbing src/sass/main.sass resources/public/main.css

sass-watch:
	sass -r sass-globbing src/sass/main.sass:resources/public/main.css --watch
