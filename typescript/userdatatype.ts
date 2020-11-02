//normal declaring an array
let arr: number[] = [1,2,3];

console.log(arr[0]);

console.log(arr[1]);
let i;
for(i in arr)
	console.log(arr[i]);

let arr1:string[] = ["one","two"] 

console.log(arr1[0]);
console.log(arr1[1]);

let arr4:any[] = [1,"two"] 

console.log(arr4[0]);
console.log(arr4[1]);

//Generic array type

let arr2: Array<number> = [1,3,4];

console.log(arr2[0]);
console.log(arr2[1]);

let arr3: Array<string> =["one","two"];
console.log(arr3[0]);
console.log(arr3[1]);