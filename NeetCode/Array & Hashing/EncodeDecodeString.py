class EncodeDecodeString:
    @staticmethod
    def encode(words):
        res = ""
        for word in words:
            res += str(len(word)) + "#" + word
        return res

    @staticmethod
    def decode(string):
        res, i = [], 0
        while i < len(string):
            j = i    
            while string[j] != "#":
                j += 1
            length = int(string[i:j])
            res.append(string[j+1 : j+length+1])
            i = j+length+1
        return res

words = ["lint", "code", "love", "you"]
encodeWords = EncodeDecodeString.encode(words)
print(EncodeDecodeString.decode(encodeWords))
