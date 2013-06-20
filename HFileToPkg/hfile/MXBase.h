//
//  MXBase.h
//  hello_lua
//
//  Created by xingchong on 6/20/13.
//
//

#ifndef hello_lua_MXBase_h
#define hello_lua_MXBase_h

#include "cocos2d.h"

USING_NS_CC;

class MXBase : public CCNode {
    
    
public:
    
    MXBase();
    
    ~MXBase();
    
    static MXBase* create();
    
    bool init();

};


#endif
