(this["webpackJsonpxavierdpt.github.io"]=this["webpackJsonpxavierdpt.github.io"]||[]).push([[0],{13:function(t,n,e){},14:function(t,n,e){},16:function(t,n,e){"use strict";e.r(n);var o=e(1),i=e.n(o),r=e(4),c=e.n(r),a=(e(13),e(3)),l=e(5),s=e(6),d=e(8),u=e(7),h=(e(14),e(0)),v=151,f=151,j=[[-1,0],[0,1],[-1,0],[0,-1]],b=[{WHITE:void 0,BLACK:void 0}],g=null,O=null,p=function(t){Object(d.a)(e,t);var n=Object(u.a)(e);function e(t){var o;return Object(l.a)(this,e),(o=n.call(this,t)).drawOnCanvas=function(){var t,n=o.state,e=n.instruction,i=n.x,r=n.y,c=n.grid,l=c[i][r],s=b[e][l];void 0===s&&(s={direction:Math.floor(4*Math.random()),instruction:Math.floor(Math.random()*(b.length+1)),color:Math.floor(2*Math.random())},b[e][l]=s,void 0===b[s.instruction]&&b.push((t={},Object(a.a)(t,0,void 0),Object(a.a)(t,1,void 0),t)));var d=i+j[s.direction][0],u=r+j[s.direction][1];if(d<0||d>=v||u<0||u>=f)return clearInterval(O),void console.log("Stopped");var h=s.instruction,p=s.color;g.fillStyle=0==p?"white":"black",g.fillRect(i,r,1,1),c[i][r]=s.color,console.log(JSON.stringify(b)),o.setState({x:d,y:u,instruction:h})},o.state={instruction:0,x:Math.floor(75.5)+1,y:Math.floor(75.5)+1,grid:Array.from({length:v},(function(){return Array.from({length:f},(function(){return 0}))}))},o}return Object(s.a)(e,[{key:"componentDidMount",value:function(){var t=document.querySelector("#canvas");g=t.getContext("2d")}},{key:"render",value:function(){var t=this;return Object(h.jsxs)("div",{className:"App",children:[Object(h.jsx)("div",{children:"Welcome"}),Object(h.jsx)("div",{children:Object(h.jsx)("canvas",{id:"canvas",width:v,height:f})}),Object(h.jsx)("div",{children:Object(h.jsx)("button",{onClick:function(){O=setInterval(t.drawOnCanvas,100)},children:"Draw canvas"})})]})}}]),e}(i.a.Component),x=function(t){t&&t instanceof Function&&e.e(3).then(e.bind(null,17)).then((function(n){var e=n.getCLS,o=n.getFID,i=n.getFCP,r=n.getLCP,c=n.getTTFB;e(t),o(t),i(t),r(t),c(t)}))};c.a.render(Object(h.jsx)(i.a.StrictMode,{children:Object(h.jsx)(p,{})}),document.getElementById("root")),x()}},[[16,1,2]]]);
//# sourceMappingURL=main.36c54a68.chunk.js.map