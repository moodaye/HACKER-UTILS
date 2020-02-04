# Example of python's iterator protocol
# uses the for ... in loop structuire
# because there is 
class Repeater:
    def __init__(self, value):
        self.value = value
        
    def __iter__(self):
        return RepeaterIterator(self)
    
class RepeaterIterator:
    def __init__(self, source):
        self.source = source
        
    def __next__(self):
        return self.source.value
    
repeater = Repeater("hello")
for item in repeater:
    print(item)
