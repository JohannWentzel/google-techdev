import sys
import collections

def longest_subsequence(stringToSearch, possibleWords):

	searchCharIndices = {}

	# Keep track of  the indices of each character used, to check against later.

	for i in range(len(stringToSearch)):
		c = stringToSearch[i]
		if c in searchCharIndices:
			searchCharIndices[c].append(i)
		else:
			searchCharIndices[c] = [i]


	# Sorting the array of possible words by length, in descending order 

	for word in sorted(possibleWords, key=lambda w: len(w), reverse=True):

		# Keep track of the current index in the search string. if it's higher than the earliest occurrence 
		# of the character we're looking for, it's not a subsequence.

		cutoffIndex = 0

		# Go through each word, checking each character to see if it's in the search string past the cutoff index.

		for i in range(len(word)):
			currentLetter = word[i]
			if currentLetter not in searchCharIndices:
				break
			# Get all possible positions of that character in the search string that are past the cutoff index.

			possiblePositions = [p for p in searchCharIndices[currentLetter] if p >= cutoffIndex]

			# No possible valid positions? Not a subsequence.

			if not possiblePositions:
				break

			cutoffIndex = possiblePositions[0] + 1

		# For those that are confused: Python for loops have an "else" case, when everything runs normally with no breaks.
		else:
			return word


if __name__ == '__main__':
	if len(sys.argv) < 3:
		print ("USAGE: python longest-subsequence.py [String to search] [Possible words (1 or more)]")
	else:
		print(longest_subsequence(sys.argv[1],sys.argv[2:]))