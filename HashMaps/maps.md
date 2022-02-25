# Maps

Being a map means relating two pieces of information, but a map also has one further requirement. Let’s consider the following table:

| Musician         |  State of Birth  
|------------------|:----------------:|
| Miles Davis      |     Illinois     | 
| John Coltrane    |  North Carolina  |  
| Duke Ellington   |       Ohio       |   
| Dizzy Gillespie  | South Carolina
| Thelonious  Monk |North Carolina
    

	

In the above table we map different jazz musicians to the state where they were born. When talking about a map we describe the inputs (jazz musicians, in this case) as the keys to the map. The output (here the state of origin) is said to be the value at a given key.

In order for a relationship to be a map, every key that is used can only be the key to a single value. In this example every musician can only have one state that they were born in, so it works. There doesn’t need to be a value for every possible key, there just can’t be more than one value for a given key. For instance, Miles Davis can’t be born in both Illinois and Kentucky.

If we looked at this relationship the other way, with states as the keys and jazz musicians born in a given state as values, this would not be a map. In the example above, if we look at “North Carolina” and try to get the jazz musician from that state, we’ll find it very difficult to do. Our relationship would give two different outputs: “John Coltrane” and “Thelonious Monk”.

We would still be able to describe that relationship with a table, but it wouldn’t be a map, and so we can’t save such a relationship using a hash map.

![Ceci est un exemple d’image](https://content.codecademy.com/courses/hash-maps-concepts/Authors.svg)


# Hash Map Methodology

In the case of a map between two things, we don’t really care about the exact sequence of the data. We only care that a given input, when fed into the map, gives the accurate output. Developing a data structure that performs this is tricky because computers care much more about values than relationships. A computer doesn’t really care to memorize the astrological signs of all of our friends, so we need to trick the computer into caring.

We perform this trick using a structure that our computer is already familiar with, an array. An array uses indices to keep track of values in memory, so we’ll need a way of turning each key in our map to an index in our array.

Imagine we want our computer to remember that our good friend Joan McNeil is a Libra. We take her name, and we turn that name into a number. Let’s say that the number we correspond with the name “Joan McNeil” is 17. We find the 17th index of the array we’re using to store our map and save the value (Libra) there.

How did we get 17, though? We use a special function that turns data like the string “Joan McNeil” into a number. This function is called a hashing function, or a hash function. Hashing functions are useful in many domains, but for our data structure the most important aspect is that a hashing function returns an array index as output.

![Ceci est un exemple d’image](https://content.codecademy.com/courses/hash-maps-concepts/AstrologicalSigns.svg)

# Hash Functions

A hash function takes a string (or some other type of data) as input and returns an array index as output. In order for it to return an array index, our hash map implementation needs to know the size of our array. If the array we are saving values into only has 4 slots, our hash map’s hashing method should not return an index bigger than that.

In order for our hash map implementation to guarantee that it returns an index that fits into the underlying array, the hash function will first compute a value using some scoring metric: this is the hash value, hash code, or just the hash. Our hash map implementation then takes that hash value mod the size of the array. This guarantees that the value returned by the hash function can be used as an index into the array we’re using.

It is actually a defining feature of all hash functions that they greatly reduce any possible inputs (any string you can imagine) into a much smaller range of potential outputs (an integer smaller than the size of our array). For this reason, hash functions are also known as compression functions.

Much like an image that has been shrunk to a lower resolution, the output of a hash function contains less data than the input. Because of this, hashing is not a reversible process. With just a hash value it is impossible to know for sure the key that was plugged into the hashing function.


# How to Write a Hash Function

You might be thinking at this point that we’ve glossed over a very important aspect of a hash table here. We’ve mentioned that a hash function is necessary, and described some features of what a hash function does, but never really given an implementation of a hash function that does not feel like a toy example.

Part of this is because a hash function needs to be simple by design. Performing complex mathematical calculations that our hash table needs to compute every time it wants to assign or retrieve a value for a key will significantly damage a hash table’s performance for two things that it should be able to do quickly.

Hash functions also need to be able to take whatever types of data we want to use as a key. We only discussed strings, a very common use case, but it’s possible to use numbers as hash table keys as well.

A very common hash function for integers, for example, is to perform the modular operation on it to make sure it’s less than the size of the underlying array. If the integer is already small enough to be an index into the array, there’s nothing to be done.

Many hash functions implementations for strings take advantage of the fact that strings are represented internally as numerical data. Frequently a hash function will perform a shift of the data bitwise, which is computationally simple for a computer to do but also can predictably assign numbers to strings.


# Basic Hash Maps

Now that we have all of the main ingredients for a hash map, let’s put them all together. First, we need some sort of associated data that we’re hoping to preserve. Second, we need an array of a fixed size to insert our data into. Lastly, we need a hash function that translates the keys of our array into indexes into the array. The storage location at the index given by a hash is called the hash bucket.

Let’s use the following example for our hash map:

| Key: Album Name        | Value: Release Year |
|------------------------|:-------------------:| 
| The Low End Theory     |        1991         | 
| Midnight Marauders     |        1993         |  
| Beats, Rhymes and Life |        1996         |   
| The Love Movement	     |        1998         |

	
	
	
	


Our map here relates to several A Tribe Called Quest studio albums with the year they were produced in. We’ll need an array of at least size 4 to contain all of these elements. And a way to turn each album name into an index into that array.

For each album name, find that album’s hash by performing the following calculation:

hash_value = ((# of lowercase 'a's in album name) + (# of number of lowercase 'e's in album name))

And then take that hash and calculate an array index by performing hash_value mod 4. Following these steps we get the following schema:

| Album Name             | Release Year |   Hash   | Hash mod 4 |
|------------------------|:------------:|:--------:|:----------:|
| The Low End Theory     |     1991     |    2     |     2      |
| Midnight Marauders     |     1993     |    3     |     3      |
| Beats, Rhymes and Life |     1996     |    5     |     1      |
| The Love Movement      |   1998       | 4        |    0       |



First, the key is translated into the hash using our hashing function. Then, our hash map performs modulo arithmetic to turn the hash into an array index.

# Collisions

Remember hash functions are designed to compress data from a large number of possible keys to a much smaller range. Because of this compression, it’s likely that our hash function might produce the same hash for two different keys. This is known as a hash collision. There are several strategies for resolving hash collisions.

The first strategy we’re going to learn about is called separate chaining. The separate chaining strategy avoids collisions by updating the underlying data structure. Instead of an array of values that are mapped to by hashes, it could be an array of linked lists!

![Ceci est un exemple d’image](https://content.codecademy.com/courses/hash-maps-concepts/Collision.svg)
