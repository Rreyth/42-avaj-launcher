all: compile

find: 
	@find * -name "*.java" > sources.txt

compile: find
	@javac @sources.txt

clean:
	@rm -f sources.txt
	@find * -name "*.class" -type f -delete

fclean: clean

run: compile
	@java -cp src avaj.Simulator scenario.txt

re: clean all

rerun: clean run

.PHONY: all find compile clean fclean run re rerun