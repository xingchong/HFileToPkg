1. Generating the lua<-->C bindings with tolua++
tolua++.exe -tCocos2d -o LuaCocos2d.cpp Cocos2d.pkg

    An ant script has been provided to generate the relevant files, to do this after
    modifying the .pkg files you should use the following command in this directory:

    ant

    This will generate the bindings file, patch it to compile successfully and move it
    to the standard destination.

2. Writing .pkg files

    1) enum keeps the same
    2) remove CC_DLL for the class defines, pay attention to multi inherites
    3) remove inline keyword for declaration and implementation
    4) remove public protect and private
    5) remove the decalration of class member variable
    6) keep static keyword
    7) remove memeber functions that declared as private or protected 
    
    
    
    ./tolua++ -H LuaCocos2d.h -o LuaCocos2d.cpp Cocos2d.pkg