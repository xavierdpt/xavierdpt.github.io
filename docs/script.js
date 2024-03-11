const links = window.xdata;
const count = Vue.ref(1);
const lis = [];
for (let k in links) {
    if (k === "") {
        continue;
    }
    const link = links[k];
    lis.push(Vue.h("li", {}, [Vue.h("a", { href: link.href }, [link.label])]));
}
const button = Vue.h('button', {
    onClick() {
        count.value = count.value + 1;
    }
}, ['Click me! ' + count.value+' world']);
const ul = Vue.h('ul', {}, lis);
const vnode = Vue.h('div', {}, [button, ul]);
Vue.createApp({ render: () => vnode }).mount('#root');