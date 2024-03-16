<result>{
    for $node in //instructions/*
    let $name := node-name($node)
    group by $name
    order by count($node)
    return <stat name="{$name}" count="{count($node)}"/>
}</result>