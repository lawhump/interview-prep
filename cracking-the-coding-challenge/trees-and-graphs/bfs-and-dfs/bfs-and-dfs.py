from collections import deque

# Included so I can define my own operator

class Infix:
    def __init__(self, function):
        self.function = function
    def __ror__(self, other):
        return Infix(lambda x, self=self, other=other: self.function(other, x))
    def __or__(self, other):
        return self.function(other)
    def __rlshift__(self, other):
        return Infix(lambda x, self=self, other=other: self.function(other, x))
    def __rshift__(self, other):
        return self.function(other)
    def __call__(self, value1, value2):
        return self.function(value1, value2)

# Adjacency list implementation

class Graph(object):

	'''
	Attributes:
		nodes - list of nodes in the graph
				normally, i'd make a node class
				but i trust my ability to implement
				a graph. i just want to implement 
				common algorithms on graphs

		edges - edges in the graph, 
				represented as a dictionary
				of lists
	'''

	def __init__(self, nodes, edges):
		self.nodes = nodes
		self.edges = edges

	def addNode(self, node):
		self.nodes.append(node);
		self.edges[node] = []

	# not going to implement now
	# remove node and corresponding
	# edges
	def removeNode(self, node):
		pass

	def addEdge(self, node1, node2):
		# only have to check the existence of
		# one, because of symmetry
		if node2 not in self.edges[node1]:
			self.edges[node1].append(node2)
			self.edges[node2].append(node1)

	# not going to implement now. remove 
	# edge between node1 and node2
	def removeEdge(self, node1, node2):
		pass

	def bfs(self, start):
		# initalization
		queue = deque([start])
		seen = [start]

		# the meat
		while queue:
			curr = queue[0]
			for adj in self.edges[curr]:
				if adj not in seen:
					queue.append(adj)
					seen.append(adj)
			queue.popleft()
		print seen

	def dfs(self, start):
		# initalization
		stack = [start]
		seen = [start]

		# the meat
		while stack:
			curr = stack.pop()
			for adj in self.edges[curr]:
				if adj not in seen:
					stack.append(adj)
					seen.append(adj)
		print seen

	# how many disconnected graphs exist
	# not going to implement (now)
	# but could be good to have
	def numberOfSubgraphs(self):
		pass

	# find path; not (yet) going to
	# implement
	def findPath(self, node1, node2):
		pass

	# find shortest path; not (yet)
	# going to implement
	def findShortestPath(self, node1, node2):
		pass

	# find nodes such that there exists
	# an edge between
	def findNeighboringNodes(self, node):
		pass

def main():
	# initialization
	nodes = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M']
	edges = {}
	for node in nodes:
		edges[node] = []

	graph = Graph(nodes, edges)

	# add edge operator
	# for readability and convenience
	_edge_ = Infix(lambda x,y: graph.addEdge(x,y)) 

	'A' |_edge_| 'B'
	'A' |_edge_| 'C'
	'A' |_edge_| 'D'
	'B' |_edge_| 'E'
	'B' |_edge_| 'F'
	'B' |_edge_| 'G'
	'C' |_edge_| 'H'
	'C' |_edge_| 'I'
	'C' |_edge_| 'J'
	'D' |_edge_| 'K'
	'D' |_edge_| 'L'
	'D' |_edge_| 'M'

	print graph.edges

	print 'Calling bfs on graph with start=A'
	graph.bfs('A')

	print 'Calling dfs on graph with start=A'
	graph.dfs('A')

if  __name__ == '__main__':main()