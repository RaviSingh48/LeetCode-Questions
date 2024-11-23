class Solution {
    public char[][] rotateTheBox(char[][] box) {
	int r = box.length, c = box[0].length;
	char[][] res = new char[c][r];
	for(int i=0; i<r; i++) {
		int lastObs = c-1;
		for(int j=c-1; j>=0; j--) {
			if(box[i][j] == '*') {
				lastObs = j-1;
				res[j][i] = '*';
			} else if(box[i][j] == '#') {
				res[j][i] = '.';
				res[lastObs--][i] = '#';
			} else {
				res[j][i] = '.';
			}
		}
	}

	int left=0, right=r-1;
	while(left < right) {
		for(int i=0; i<c; i++) {
			char temp = res[i][left];
			res[i][left] = res[i][right];
			res[i][right] = temp;
		}
		left++;
		right--;
	}

	return res;
}
}