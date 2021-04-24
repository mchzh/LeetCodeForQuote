class TrieNode:

    def __init__(self, letter=None):
        """
        # initialize TrieNode
        # it should have link to the downstream neighbirs
        # also a signal that checks whether current node is end of
        # a word
        """
        self.next={}
        self.isEnd=False
        
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        head=self.root
        for c in word:
            if c not in head.next:
                head.next[c]=TrieNode()
            head=head.next[c]
        head.isEnd=True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        head=self.root
        for c in word:
            if c not in head.next:
                return False
            head=head.next[c]
        return head.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        head=self.root
        for c in prefix:
            if c not in head.next:
                return False
            head=head.next[c]
        return True
