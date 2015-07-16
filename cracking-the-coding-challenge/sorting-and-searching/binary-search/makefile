JFLAGS = -g
JC = javac

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	binary-search.java \
	Node.java \
	BST.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class