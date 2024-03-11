const links = window.xdata;
const lis = [];
for (let k in links) {
    if (k === "") {
        continue;
    }
    const link = links[k];
    lis.push(Vue.h("li", {}, [Vue.h("a", { href: link.href }, [link.label])]));
}
const vnode = Vue.h('ul', {}, lis);
Vue.createApp({ render: () => vnode }).mount('#root');