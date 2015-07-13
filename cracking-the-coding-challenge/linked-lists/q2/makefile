JFLAGS = -g
JC = javac

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	q2.java \
	Node.java \
	LinkedList.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class