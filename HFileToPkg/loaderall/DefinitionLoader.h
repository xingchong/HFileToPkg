//
//  Created by auto tools on Fri Jun 21 00:47:41 CST 2013
//  Copyright (c) 2012年 rr. All rights reserved.

#include "cocos2d.h"

#include "MXBaseLoad.h"

class DefinitionLoader{
  
public:
    static void definitionLoader(lua_State *m_state){
		tolua_MXBase_open(m_state);
    }
};