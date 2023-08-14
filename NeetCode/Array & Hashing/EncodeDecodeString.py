class EncodeDecodeString:
    @staticmethod
    def encode(self, words):
        res = ""
        for word in words:
            res += ":" + "#" + word
            
        return res

    @staticmethod
    def decoder(self, string):
        res, i = [], 0
        
        while i < len(string):
            j = i    
            while string[j] != "#":
                j += 1
            length = int(string[i:j])
            res.append(string[j+1 : j+length+1])
            i = j+1+length

        return res

    words = ["lint", "code", "love", "you"]
    encodeWords = encode(words)
    print(decoder(encodeWords))
