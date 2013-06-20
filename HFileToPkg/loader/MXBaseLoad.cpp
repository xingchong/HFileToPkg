/*
** Lua binding: MXBase
** Generated automatically by tolua++-1.0.92 on Fri Jun 21 00:47:41 2013.
*/

#ifndef __cplusplus
#include "stdlib.h"
#endif
#include "string.h"

#include "tolua++.h"

/* Exported function */
TOLUA_API int  tolua_MXBase_open (lua_State* tolua_S);

#include "MXBase.h"
#include "cocos2d.h"

/* function to release collected object via destructor */
#ifdef __cplusplus

static int tolua_collect_MXBase (lua_State* tolua_S)
{
 MXBase* self = (MXBase*) tolua_tousertype(tolua_S,1,0);
	Mtolua_delete(self);
	return 0;
}
#endif


/* function to register type */
static void tolua_reg_types (lua_State* tolua_S)
{
 tolua_usertype(tolua_S,"MXBase");
 tolua_usertype(tolua_S,"CCNode");
}

/* method: new of class  MXBase */
#ifndef TOLUA_DISABLE_tolua_MXBase_MXBase_new00
static int tolua_MXBase_MXBase_new00(lua_State* tolua_S)
{
#ifndef TOLUA_RELEASE
 tolua_Error tolua_err;
 if (
     !tolua_isusertable(tolua_S,1,"MXBase",0,&tolua_err) ||
     !tolua_isnoobj(tolua_S,2,&tolua_err)
 )
  goto tolua_lerror;
 else
#endif
 {
  {
   MXBase* tolua_ret = (MXBase*)  Mtolua_new((MXBase)());
    tolua_pushusertype(tolua_S,(void*)tolua_ret,"MXBase");
  }
 }
 return 1;
#ifndef TOLUA_RELEASE
 tolua_lerror:
 tolua_error(tolua_S,"#ferror in function 'new'.",&tolua_err);
 return 0;
#endif
}
#endif //#ifndef TOLUA_DISABLE

/* method: new_local of class  MXBase */
#ifndef TOLUA_DISABLE_tolua_MXBase_MXBase_new00_local
static int tolua_MXBase_MXBase_new00_local(lua_State* tolua_S)
{
#ifndef TOLUA_RELEASE
 tolua_Error tolua_err;
 if (
     !tolua_isusertable(tolua_S,1,"MXBase",0,&tolua_err) ||
     !tolua_isnoobj(tolua_S,2,&tolua_err)
 )
  goto tolua_lerror;
 else
#endif
 {
  {
   MXBase* tolua_ret = (MXBase*)  Mtolua_new((MXBase)());
    tolua_pushusertype(tolua_S,(void*)tolua_ret,"MXBase");
    tolua_register_gc(tolua_S,lua_gettop(tolua_S));
  }
 }
 return 1;
#ifndef TOLUA_RELEASE
 tolua_lerror:
 tolua_error(tolua_S,"#ferror in function 'new'.",&tolua_err);
 return 0;
#endif
}
#endif //#ifndef TOLUA_DISABLE

/* method: delete of class  MXBase */
#ifndef TOLUA_DISABLE_tolua_MXBase_MXBase_delete00
static int tolua_MXBase_MXBase_delete00(lua_State* tolua_S)
{
#ifndef TOLUA_RELEASE
 tolua_Error tolua_err;
 if (
     !tolua_isusertype(tolua_S,1,"MXBase",0,&tolua_err) ||
     !tolua_isnoobj(tolua_S,2,&tolua_err)
 )
  goto tolua_lerror;
 else
#endif
 {
  MXBase* self = (MXBase*)  tolua_tousertype(tolua_S,1,0);
#ifndef TOLUA_RELEASE
  if (!self) tolua_error(tolua_S,"invalid 'self' in function 'delete'", NULL);
#endif
  Mtolua_delete(self);
 }
 return 0;
#ifndef TOLUA_RELEASE
 tolua_lerror:
 tolua_error(tolua_S,"#ferror in function 'delete'.",&tolua_err);
 return 0;
#endif
}
#endif //#ifndef TOLUA_DISABLE

/* method: create of class  MXBase */
#ifndef TOLUA_DISABLE_tolua_MXBase_MXBase_create00
static int tolua_MXBase_MXBase_create00(lua_State* tolua_S)
{
#ifndef TOLUA_RELEASE
 tolua_Error tolua_err;
 if (
     !tolua_isusertable(tolua_S,1,"MXBase",0,&tolua_err) ||
     !tolua_isnoobj(tolua_S,2,&tolua_err)
 )
  goto tolua_lerror;
 else
#endif
 {
  {
   MXBase* tolua_ret = (MXBase*)  MXBase::create();
    tolua_pushusertype(tolua_S,(void*)tolua_ret,"MXBase");
  }
 }
 return 1;
#ifndef TOLUA_RELEASE
 tolua_lerror:
 tolua_error(tolua_S,"#ferror in function 'create'.",&tolua_err);
 return 0;
#endif
}
#endif //#ifndef TOLUA_DISABLE

/* method: init of class  MXBase */
#ifndef TOLUA_DISABLE_tolua_MXBase_MXBase_init00
static int tolua_MXBase_MXBase_init00(lua_State* tolua_S)
{
#ifndef TOLUA_RELEASE
 tolua_Error tolua_err;
 if (
     !tolua_isusertype(tolua_S,1,"MXBase",0,&tolua_err) ||
     !tolua_isnoobj(tolua_S,2,&tolua_err)
 )
  goto tolua_lerror;
 else
#endif
 {
  MXBase* self = (MXBase*)  tolua_tousertype(tolua_S,1,0);
#ifndef TOLUA_RELEASE
  if (!self) tolua_error(tolua_S,"invalid 'self' in function 'init'", NULL);
#endif
  {
   bool tolua_ret = (bool)  self->init();
   tolua_pushboolean(tolua_S,(bool)tolua_ret);
  }
 }
 return 1;
#ifndef TOLUA_RELEASE
 tolua_lerror:
 tolua_error(tolua_S,"#ferror in function 'init'.",&tolua_err);
 return 0;
#endif
}
#endif //#ifndef TOLUA_DISABLE

/* Open function */
TOLUA_API int tolua_MXBase_open (lua_State* tolua_S)
{
 tolua_open(tolua_S);
 tolua_reg_types(tolua_S);
 tolua_module(tolua_S,NULL,0);
 tolua_beginmodule(tolua_S,NULL);
  #ifdef __cplusplus
  tolua_cclass(tolua_S,"MXBase","MXBase","CCNode",tolua_collect_MXBase);
  #else
  tolua_cclass(tolua_S,"MXBase","MXBase","CCNode",NULL);
  #endif
  tolua_beginmodule(tolua_S,"MXBase");
   tolua_function(tolua_S,"new",tolua_MXBase_MXBase_new00);
   tolua_function(tolua_S,"new_local",tolua_MXBase_MXBase_new00_local);
   tolua_function(tolua_S,".call",tolua_MXBase_MXBase_new00_local);
   tolua_function(tolua_S,"delete",tolua_MXBase_MXBase_delete00);
   tolua_function(tolua_S,"create",tolua_MXBase_MXBase_create00);
   tolua_function(tolua_S,"init",tolua_MXBase_MXBase_init00);
  tolua_endmodule(tolua_S);
 tolua_endmodule(tolua_S);
 return 1;
}


#if defined(LUA_VERSION_NUM) && LUA_VERSION_NUM >= 501
 TOLUA_API int luaopen_MXBase (lua_State* tolua_S) {
 return tolua_MXBase_open(tolua_S);
};
#endif

