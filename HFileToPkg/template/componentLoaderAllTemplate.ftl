//
//  Created by auto tools on ${date}
//  Copyright (c) 2012年 rr. All rights reserved.

#include "cocos2d.h"

<#list includeNameList as include>
#include "${include}Load.h"
</#list>

class DefinitionLoader{
  
public:
    static void definitionLoader(lua_State *m_state){
        <#list includeNameList as include>
		tolua_${include}_open(m_state);
		</#list>
    }
};