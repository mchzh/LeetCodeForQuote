First, determine which letters are bold and store that information in mask[i] = if i-th character is bold. Then, insert the tags at the beginning and end of groups. The start of a group is if and only if (mask[i] and (i == 0 or not mask[i-1])), and the end of a group is similar.

It is same as 758. Bold Words in String.
