(this["webpackJsonpxavierdpt.github.io"]=this["webpackJsonpxavierdpt.github.io"]||[]).push([[0],{13:function(e,t,n){},14:function(e,t,n){},16:function(e,t,n){"use strict";n.r(t);var r=n(1),i=n.n(r),o=n(3),s=n.n(o),c=(n(13),n(7)),a=n(4),l=n(5),u=n(8),d=n(6),h=(n(14),n(0)),b=[[-1,0],[0,1],[1,0],[0,-1]],f=function(e){return Array.from({length:e},(function(){return{WHITE:void 0,BLACK:void 0}}))},g=function(e){return{width:2*e+1,height:2*e+1}},p=function(e,t){for(var n=g(e),r=n.width,i=n.height,o=Array.from({length:r},(function(){return Array.from({length:i},(function(){return{color:0,pristine:!0}}))})),s=0;s<t;++s){for(var c=2*s;c<r-2*s;++c)o[c][2*s].color=1,o[c][i-1-2*s].color=1;for(var a=2*s;a<i-2*s;++a)o[2*s][a].color=1,o[r-1-2*s][a].color=1}return{instruction:0,count:0,x:e+1,y:e+1,grid:o}},m=[],v=0,j=function(e,t){for(var n=[],r=0,i=[0,1,2,3];r<i.length;r++)for(var o=i[r],s=0,c=[1,0];s<c.length;s++)for(var a=c[s],l=0;l<e;++l)n.push({direction:o,color:a,instruction:l});if(t){for(var u=[];n.length>0;){var d=Math.floor(Math.random()*n.length);u.push(n[d]),n.splice(d,1)}n=u,console.log("Randomized possible actions:"),console.log(JSON.stringify(n))}return n},x=["W","B"],S=["\ud83e\udc1e","\ud83e\udc1f","\ud83e\udc1c","\ud83e\udc1d"],O=null,y=null,C=null,z=[],k="123456789ABCDEF".split("").map((function(e){return"#".concat(e).concat(e).concat(e).concat(e).concat(e).concat(e)})),w="INSTRUCTIONS_EXHAUSTED",A=function(e){Object(u.a)(n,e);var t=Object(d.a)(n);function n(e){var r;return Object(a.a)(this,n),(r=t.call(this,e)).start=function(e){var t=r.state,n=t.gridSize,i=t.instructions,o=t.numberOfOuterWalls,s=t.cellSize,c=t.increaseSpeed,a=t.instructionsSteps,l=t.randomizePossibleActions,u=g(n),d=u.width,h=u.height;O=f(i),y=p(n,o),e&&(C=j(i,l));var b=r.getContext();b.fillStyle="darkgray";for(var m=0;m<d;++m)for(var v=0;v<h;++v)1===y.grid[m][v].color&&b.fillRect(m*s,v*s,s,s);r.setState({context:b,intervalHandle:setInterval((function(){var e=r.state.currentSpeed;r.setState({currentSpeed:null===e?a:c?e+1:e},(function(){var e=r.state.currentSpeed;r.steps(e)}))}),1)})},r.stop=function(e){var t=r.state,n=t.intervalHandle,i=t.pauseHandle;clearInterval(n),clearTimeout(i),r.setState({intervalHandle:null,pauseHandle:null},e)},r.steps=function(e){for(var t=r.state,n=t.cellSize,i=t.pauseDuration,o=t.context,s={},c=!1,a=!1,l=0;l<e;++l){var u=r.step();if(u.cell&&(s["".concat(u.cell.x,"-").concat(u.cell.y)]=u.cell),u.stopped){c=!0,a=u.instructionsExhausted;break}}for(var d in s){var h=s[d].x,b=s[d].y,f=s[d].colorToWrite;o.fillStyle=1===f?"black":"white",o.fillRect(h*n,b*n,n,n)}c&&r.stop((function(){r.setState({pauseHandle:setTimeout((function(){r.setState({pauseHande:null},(function(){r.nextProgram(a),r.start(!1)}))}),i)})}))},r.step=function(){var e=r.state,t=e.generateRandomActions,n=e.gridSize,i=e.maxInstructionCount,o=y,s=o.instruction,c=o.x,a=o.y,l=o.grid,u=g(n),d=u.width,h=u.height,f=l[c][a].color,p=O[s][f];if(void 0===p&&(p=function(e){if(e){var t=Math.floor(Math.random()*C.length);return C[t]}if(void 0===m[v])m[v]=0;else{for(var n=!0,r=v+1;r<m.length;++r)m[r]!==C.length-1&&(n=!1);if(n){if(0===v&&m[v]===C.length-1)return w;++m[v],m.splice(v+1)}}var i=C[m[v]];return++v,i}(t),O[s][f]=p),p===w)return{stopped:!0,cell:null,instructionsExhausted:!0};var j=c+b[p.direction][0],x=a+b[p.direction][1];if(j<0||j>=d||x<0||x>=h||y.count>i&&!r.state.awesome)return{stopped:!0,cell:null,instructionsExhausted:!1};var S=p.instruction,z=p.color;return l[c][a].color=z,l[c][a].pristine=!1,y.x=j,y.y=x,y.instruction=S,++y.count,{cell:{x:c,y:a,colorToWrite:z},stopped:!1,instructionsExhausted:!1}},r.nextProgram=function(e){var t=r.state,n=t.gridSize,i=t.cellSize,o=t.instructions,s=t.maxInstructionCount,a=t.numberOfOuterWalls,l=t.context,u=t.instructionsSteps,d=t.historyLength;console.log(JSON.stringify(m));var h=g(n),b=h.width,w=h.height,A=y.grid,N=function(e,t,n,r,i){for(var o=0,s=0;s<n;++s)for(var c=0;c<r;++c)e[s][c].pristine||++o;return o+(1-t/i)}(A,y.count,b,w,s),E=!1;if(0===z.length)E=!0;else{var F,I=Object(c.a)(z);try{for(I.s();!(F=I.n()).done;){F.value.score<N&&(E=!0)}}catch(B){I.e(B)}finally{I.f()}}if(E){console.log(function(e){for(var t="",n=!1,r=0;r<e.length;++r)for(var i=0,o=[0,1];i<o.length;i++){var s=o[i];if(n&&(t+=","),e[r]){var c=e[r][s];c?(t+=r,t+=x[s],t+=S[c.direction],t+=x[c.color],t+=c.instruction,n=!0):n=!1}}return t}(O)),z.unshift({grid:A,score:N}),z.sort((function(e,t){return e.score===t.score?0:e.score<t.score?1:-1})),z.length>Math.min(d,k.length)&&z.splice(z.length-1),console.log("High scores"),console.group();for(var H="123456789ABCDEF".split(""),R=0;R<z.length;++R)console.log("".concat(H[R]," - ").concat(z[R].score));console.groupEnd()}l.fillStyle="#EEEEEE",l.fillRect(0,0,b*i,w*i);for(var P=z.length-1;P>=0;--P){var T=z[P].grid,W=k[P];l.fillStyle=W,1===z.length&&(l.fillStyle="red");for(var D=0;D<b;++D)for(var L=0;L<w;++L)1===z.length?1===T[D][L].color&&l.fillRect(D*i,L*i,i,i):T[D][L].pristine||l.fillRect(D*i,L*i,i,i)}e?(console.log("Switching to program with "+(o+1)+" instructions"),r.setState({instructions:o+1,currentSpeed:u},(function(){var e=r.state,t=e.instructions,n=e.gridSize,i=e.numberOfOuterWalls,o=e.randomizePossibleActions;C=j(t,o),O=f(t),y=p(n,i),m.splice(v),v=0}))):r.setState({currentSpeed:u},(function(){O=f(o),y=p(n,a),m.splice(v),v=0}))},r.skipToNext=function(){var e=r.state.maxInstructionCount;y.count+=e},r.bestNotGood=function(){z.length>0&&z.pop()},r.awesome=function(){r.setState({awesome:!r.state.awesome})},r.state={intervalHandle:null,pauseHandle:null,instructions:10,instructionsSteps:1,maxInstructionCount:1e6,pauseDuration:1,gridSize:150,cellSize:2,generateRandomActions:!1,numberOfOuterWalls:0,context:null,increaseSpeed:!0,currentSpeed:null,historyLength:1,randomizePossibleActions:!0,awesome:!1},r}return Object(l.a)(n,[{key:"getContext",value:function(){return document.querySelector("#canvas").getContext("2d")}},{key:"render",value:function(){var e,t=this,n=this.state,r=n.intervalHandle,i=n.pauseHandle,o=n.instructions,s=n.instructionsSteps,c=n.maxInstructionCount,a=n.pauseDuration,l=n.gridSize,u=n.cellSize,d=n.generateRandomActions,b=n.numberOfOuterWalls,f=n.increaseSpeed,p=n.currentSpeed,m=n.historyLength,v=n.randomizePossibleActions,j=null!==r||null!==i,x=g(l),S=x.width,O=x.height;return Object(h.jsxs)("div",{className:"App",children:[Object(h.jsxs)("div",{children:[Object(h.jsx)("label",{htmlFor:"instructions",children:"Number of instructions"}),Object(h.jsx)("input",{min:1,name:"instructions",type:"number",value:o,disabled:j,onChange:function(e){return t.setState({instructions:Number(e.target.value)})}})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("label",{htmlFor:"maxInstructionCount",children:"Max instruction count"}),Object(h.jsx)("input",{min:1,name:"maxInstructionCount",type:"number",value:c,disabled:j,onChange:function(e){return t.setState({maxInstructionCount:Number(e.target.value)})}})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("label",{htmlFor:"instructionsSteps",children:"Instructions per step"}),Object(h.jsx)("input",{min:1,name:"instructionsSteps",type:"number",value:s,disabled:j,onChange:function(e){return t.setState({instructionsSteps:Number(e.target.value)})}})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("input",{type:"checkbox",name:"increaseSpeed",checked:f,onChange:function(e){return t.setState({increaseSpeed:e.target.checked})}}),Object(h.jsx)("label",{htmlFor:"increaseSpeed",children:"Increase speed"})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("label",{htmlFor:"pauseDuration",children:"Pause between runs"}),Object(h.jsx)("input",{min:1,name:"pauseDuration",type:"number",value:a,disabled:j,onChange:function(e){return t.setState({pauseDuration:Number(e.target.value)})}})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("label",{htmlFor:"gridSize",children:"Grid size"}),Object(h.jsx)("input",{min:0,name:"gridSize",type:"number",value:l,disabled:j,onChange:function(e){return t.setState({gridSize:Number(e.target.value)})}})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("label",{htmlFor:"cellSize",children:"Cell size"}),Object(h.jsx)("input",{min:0,name:"cellSize",type:"number",value:u,disabled:j,onChange:function(e){return t.setState({cellSize:Number(e.target.value)})}})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("input",{type:"checkbox",name:"generateRandomActions",checked:d,onChange:function(e){return t.setState({generateRandomActions:e.target.checked})}}),Object(h.jsx)("label",{htmlFor:"generateRandomActions",children:"Generate random actions"})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("input",{type:"checkbox",name:"randomizePossibleActions",checked:v,onChange:function(e){return t.setState({randomizePossibleActions:e.target.checked})}}),Object(h.jsx)("label",{htmlFor:"randomizePossibleActions",children:"Randomize possible actions"})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("label",{htmlFor:"numberOfOuterWalls",children:"Number of outer walls"}),Object(h.jsx)("input",{min:0,name:"numberOfOuterWalls",type:"number",value:b,disabled:j,onChange:function(e){return t.setState({numberOfOuterWalls:Number(e.target.value)})}})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("label",{htmlFor:"historyLength",children:"History length"}),Object(h.jsx)("input",{name:"historyLength",type:"number",value:m,disabled:j,max:k.length,min:0,onChange:function(e){return t.setState({historyLength:Number(e.target.value)})}})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("button",{disabled:j,onClick:function(){return t.start(!0)},children:"Start"}),Object(h.jsx)("button",{disabled:!j,onClick:function(){return t.stop()},children:"Stop"}),Object(h.jsx)("button",{disabled:!j,onClick:function(){return t.skipToNext()},children:"Skip to next"}),Object(h.jsx)("button",{onClick:function(){return t.bestNotGood()},children:"Best is not good"}),Object(h.jsxs)("button",{onClick:function(){return t.awesome()},children:["Awesome",this.state.awesome?" !":""]})]}),Object(h.jsxs)("div",{children:["Current speed: ",p]}),Object(h.jsxs)("div",{children:["Current count: ",null===(e=y)||void 0===e?void 0:e.count]}),Object(h.jsx)("div",{children:Object(h.jsx)("canvas",{id:"canvas",width:S*u,height:O*u})})]})}}]),n}(i.a.Component),N=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,17)).then((function(t){var n=t.getCLS,r=t.getFID,i=t.getFCP,o=t.getLCP,s=t.getTTFB;n(e),r(e),i(e),o(e),s(e)}))};s.a.render(Object(h.jsx)(i.a.StrictMode,{children:Object(h.jsx)(A,{})}),document.getElementById("root")),N()}},[[16,1,2]]]);
//# sourceMappingURL=main.7db44fd9.chunk.js.map