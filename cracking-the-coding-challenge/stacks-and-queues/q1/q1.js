// Figured I'd try another language.

// Let me know if you notice any bugs!
// Or if you have a question in my implementation, for that
// matter.
// 
// That'd be much appreciated.

function ThreeStacks (ss) {

	// I'm assuming the stack only acceots non-negative values.
	// This assumption comes into play in the isEmpty function.

	this.size = 3*ss;
	this.sectionSize = ss;
	this.sectionOneOffset = 0;
	this.sectionTwoOffset = 0;
	this.sectionThreeOffset = 0;

	// Javascript is so beautiful. *sigh*
	// Initialize array. Idk if JS puts garbage in uninitialized memory or not. W/e.
	this.array = Array.apply(null, new Array(this.size)).map(Number.prototype.valueOf,-1);

	// Some functions that'd be conventient
	// resize()
	// peek()
}

ThreeStacks.prototype.pushToStack = function(stackNumber, value) {
	var index = this.sectionSize * (stackNumber-1);

	if (this.isFull(stackNumber)) {
		return;
	}

	if (stackNumber === 1) {
		this.array[index+this.sectionOneOffset] = value;
		this.sectionOneOffset++;
	}
	else if (stackNumber === 2) {
		this.array[index+this.sectionTwoOffset] = value;
		this.sectionTwoOffset++;
	}
	else {
		this.array[index+this.sectionThreeOffset] = value;
		this.sectionThreeOffset++;
	}
	return;
}

ThreeStacks.prototype.popFromStack = function (stackNumber) {
	var retVal;
	var index = this.sectionSize * (stackNumber-1);

	if (this.isEmpty(stackNumber)) {
		return -1;
	}

	if (stackNumber === 1) {
		retVal = this.array[index+this.sectionOneOffset];
		this.array[index+this.sectionOneOffset] = -1;
		this.sectionOneOffset--;
	}
	else if (stackNumber === 2) {
		retVal = this.array[index+this.sectionTwoOffset];
		this.array[index+this.sectionTwoOffset] = -1;
		this.sectionTwoOffset--;
	}
	else {
		retVal = this.array[index+this.sectionThreeOffset];
		this.array[index+this.sectionThreeOffset] = -1;
		this.sectionThreeOffset--;
	}
	return retVal;
}

ThreeStacks.prototype.isEmpty = function (stackNumber) {
	var val;
	var index = this.sectionSize * (stackNumber-1);
	if (stackNumber === 1) {
		val = this.array[index+this.sectionOneOffset];
		return ((this.sectionOneOffset === 0 && val === -1) ? true : false);
	}
	else if (stackNumber === 2) {
		val = this.array[index+this.sectionTwoOffset];
		return ((this.sectionTwoOffset === 0 && val === -1) ? true : false);
	}
	else {
		val = this.array[index+this.sectionThreeOffset];
		return ((this.sectionThreeOffset === 0 && val === -1) ? true : false);
	}
}

ThreeStacks.prototype.isFull = function (stackNumber) {
	if (stackNumber === 1) {
		return ((this.sectionOneOffset === (this.sectionSize)) ? true : false);
	}
	else if (stackNumber === 2) {
		return ((this.sectionTwoOffset === (this.sectionSize)) ? true : false);
	}
	else {
		return ((this.sectionThreeOffset === (this.sectionSize)) ? true : false);
	}
}

var stack = new ThreeStacks(4);

for (var i=0; i<3; i++) {
	stack.pushToStack(1, i);
	stack.pushToStack(2, 2*i);
	stack.pushToStack(3, 3*i);
}

console.log(stack.array);

console.log("stack.pushToStack(2, 10);");
stack.pushToStack(2, 10);
console.log("stack.pushToStack(2, 12);");
stack.pushToStack(2, 12);


console.log("stack.popFromStack(1)");
stack.popFromStack(1);
console.log("stack.popFromStack(1)");
stack.popFromStack(1);

console.log(stack.array);

console.log("stack.popFromStack(3) four times");
stack.popFromStack(3);
stack.popFromStack(3);
stack.popFromStack(3);
stack.popFromStack(3);

console.log(stack.array);

