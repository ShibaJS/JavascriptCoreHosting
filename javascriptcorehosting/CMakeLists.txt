cmake_minimum_required(VERSION 3.4.1)

include_directories(
        src/main/JavaScriptCore/include
)

set( SOURCES
        src/main/cpp/JSContext.cpp
        src/main/cpp/JSObject.cpp
        src/main/cpp/JSString.cpp
        src/main/cpp/JSValue.cpp
        src/main/cpp/Instance.cpp
        src/main/cpp/JSFunction.cpp
)

set(CURRENT_DIR ${CMAKE_SOURCE_DIR})
message("CURRENT_DIR:" ${CMAKE_SOURCE_DIR})

add_library(jsc SHARED IMPORTED)
set_target_properties( # Specifies the target library.
        jsc PROPERTIES
        IMPORTED_LOCATION "${CURRENT_DIR}/src/main/JavaScriptCore/jni/${ANDROID_ABI}/libjsc.so")

add_library( # Specifies the name of the library.
             jsc-hosting

             # Sets the library as a shared library.
             SHARED

             ${SOURCES}
             )
             


find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

target_link_libraries( jsc-hosting jsc ${log-lib} )
