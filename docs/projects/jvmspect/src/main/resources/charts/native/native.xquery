<nativeMethods>{
    for $method in //*[@native="true"]/..
    let $class := $method/../../thisClass/constant/@name
    group by $class
    return <class name="{$class}" count="{count($method)}">{
        for $m in $method
        return <method name="{$m/@name}" />
    }</class>
}</nativeMethods>