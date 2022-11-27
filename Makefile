JC = javac
JAVA = java
VIEWER = more
JAR = jar
FLAGS = cfm

FILES = App.java \
	Start.java \
	Game.java \
	Procedure.java

MAIN = Hangman.jar


.PHONY: run clean view


run: $(FILES)
	@$(JC) $(FILES)
	$(JAR) $(FLAGS) $(MAIN)  Manifest.txt *.class
	$(JAVA) -$(JAR) $(MAIN)

view: $(FILES) README.md
	$(VIEWER) README.md
	$(VIEWER) $(FILES)

clean:
	- rm *.class
	- rm $(MAIN)

