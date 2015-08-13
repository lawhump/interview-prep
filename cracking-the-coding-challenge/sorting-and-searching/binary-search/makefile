JFLAGS = -g
JC = javac

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Node.java \
	nAryTree.java \
	Trees.java \
	BinaryTree.java \
	binarySearch.java \
	BST.java \
	basicBinaryTree.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class