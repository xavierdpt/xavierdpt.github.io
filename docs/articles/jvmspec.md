In this little project, I decided to read the Java Virtual Machine Specification again.

The latest Java version at this time is 21, so I went for that one.

The most important parts are the class file format (section 4), which defines, in particular, the constant pool and attribute sections, and the instruction format (section 6). These are the most important sections for parsing the bytecode binary data.

## Getting the class files

But first, a little hurdle, in recent versions of the OpenJDK, the class files are stored in a extension-less `modules` file. Fortunaltely, it's possible to extract them using the `jimage` tool that is provided with OpenJDK.

So I wrote a little Java program that just runs this tool, and I got 27 643 `.class` files.

## Parsing the bytecode

Next, I embarked into iterating through all those files, to see what they contained.

The constant pool defines a number of constant strings, but also other objects that refer to these strings by index, and so one. For example, `Class` constants are just an index and a refernce to a string that represents the name of the class, and `NameAndType` are pairs of an index to a string that represents the name, and another string that represents the type.

Some objects from the constant pool use up to slots, and that's the main issue with parsing the constant pool.

Fields and methods are made of straightforward data, mostly access flags and index to objects in the constant pool, but also something they call `attributes`. And then the class itself contains some `attributes` at the end.

Attributes are chunks of data whose format depend on the section name. I only parsed the sections that I found in the first few files, but I have a setup that will help me quickly identify which attributes section to do next.

One particularly noteworthy `attribute` structure is the `Code` attribute. This contains the actual machine instructions and the exception table.

The format of the instructions is pretty straightforward. All instructions are defined with a single opcode, and almost all of them take a fixed number of bytes as arguments. The `wide` instruction makes the following instruction larger, and the two special instructions are the `tableswitch` and `lookupswitch` instructions, which be padded so that the payload is aligned to 4 bytes. This required a few adjustments before getting right.

## Doing something with it

In order to check that my parser works correctly, I need some output.

This naturally invited me to dump all my content in XML files which represent the same content as the bytecode in a more human-readable format.

So that produced a folder with 27 643 numbered XML files in it.

## Searching in the XML files

Now that I have a bunch of XML files, I'd like to see what's inside. But that's a lot of data.

Therefore, I wrote another program to import that data into an XML database, using BaseX.

BaseX is mostly a GUI tool to manage XML data and query it using XQuery. But it is written in Java, and the files can be use to start and manage a server and a client in the same Java program, which is good for automation.

This allowed be to automate the import and query part so that when my XML dumper changes, I can update the files and import them again from a single click of the mouse.

## Sample query

I have a few ideas for query, but the first that came to mind is to group the instructions by number of occurences. Thanks to having an XML database, I just need to run the following XQuery query:

```
<result>{
    for $node in //instructions/*
    let $name := node-name($node)
    group by $name
    order by count($node)
    return <stat name="{$name}" count="{count($node)}"/>
}</result>
```

And then, now that I have data, I wrote it into an HTML file that uses ECharts to display that data as treemap. This allows to see at a glance which instructions are used most often, and also to zoom in and find that some instructions are almost never used.

## Next steps

I will update the XML dumper to add information about access flags, so that I can identify all native methods in the OpenJDK.

I can also do a query to count group the attribute sections and find which ones are use the most often and which ones take the most space.


