JFLAGS = -g
JC = javac

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	nAryTree.java \
	Trees.java \
	BinaryTree.java \
	binarySearch.java \
	Node.java \
	BST.java \
	basicBinaryTree.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class