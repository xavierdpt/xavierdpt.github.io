const links = window.xdata;

const lis = [];
for (let k in links) {
    if (k === "") {
        continue;
    }
    const link = links[k];
    lis.push(Vue.h("li", {}, [Vue.h("a", { href: link.href }, [link.label])]));
}

const button = {
    setup() {
        const count = Vue.ref(1);
        return () => {
            return Vue.h('button', {
                onClick() {
                    count.value = count.value + 1;
                }
            }, ['Click me! (' + count.value + ')']);
        }
    }
};

async function fetchArticle() {
    const response = await fetch("articles/test-article.md");
    const text = await response.text();
    return text;
}

const button2 = {
    setup() {
        const content = Vue.ref("Nothing");
        return () => {
            return Vue.h('div', {}, [
                Vue.h('button', {
                    onClick() {
                        fetchArticle().then(text => content.value = text);
                    }
                }, ['Fetch!']),
                h('div', { domProps: { innerHTML: marked.parse(content.value) } }, [])
            ]);
        }
    }
};



const ul = Vue.h('ul', {}, lis);
const vnode = Vue.h('div', {}, [Vue.h(button), Vue.h(button2), ul]);
Vue.createApp({ render: () => vnode }).mount('#root');