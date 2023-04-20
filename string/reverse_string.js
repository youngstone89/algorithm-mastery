// Javascript program to reverse string without
// affecting it's special character

function reverse(s)
{
	// creating character array of size
	// equal to length of string
	let temp=new Array(s.length);
    let x = 0;
    // iterate through s and store alphabetic characters
    for (let i = 0; i < s.length; i++){
        if (s[i] >= 'a' && s[i] <= 'z' || s[i] >= 'A' && s[i] <= 'Z') {
            temp[x] = s[i];
            x += 1;
        }
    }
	
	// reversing the character array
	//reverse(temp, temp + x);
	let str="";
	for(let i=x-1; i>=0; i--)
	{
		str+=temp[i];
	}

	x = 0;
	let ans=""
	for (let i = 0; i < s.length; i++) {
		if (s[i] >= 'a' && s[i] <= 'z'
			|| s[i] >= 'A' && s[i] <= 'Z') {
			// updating the original string
			ans+= str[x];
			x++;
		}
		else
			ans+=s[i];
	}
	console.log("reversed string is: " + ans);
}
// driver code
	let s = "Ab,c,de!$";
	// function call
	reverse(s);
