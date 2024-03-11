const links = window.xdata;

const roots = [];
const children = {};
for (let key in links) {
    const { label, href, parent } = links[key];
    if (parent !== undefined) {
        if (children[parent] === undefined) {
            children[parent] = [];
        }
        children[parent].push(key);
    } else {
        roots.push(key);
    }
}

const expandButton = {
    setup() {
        return () => {
            return Vue.h("span", {}, ["+"]);
        }
    }
}

function rn(key) {
    const childKeys = children[key];
    return childKeys ? [Vue.h('ul', {}, childKeys.map(childKey => {
        const { href, label } = links[childKey];
        const hasChildren = !!children[childKey]
        return Vue.h('li', {}, [
            Vue.h("a", { href, target: '_blank' }, [label]),
            ... (hasChildren ? [Vue.h(expandButton)] : []),
            ...rn(childKey)
        ]);
    }))] : [];
}

function r0() {
    return Vue.h('ul', {}, roots.map(key => {
        const { href, label } = links[key];
        const hasChildren = !!children[key]
        return Vue.h('li', {}, [
            Vue.h("a", { href, target: '_blank' }, [label]),
            ... (hasChildren ? [Vue.h(expandButton)] : []),
            ...rn(key)
        ]);
    }));
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
                        fetchArticle().then(text => content.value = marked.parse(text));
                        console.log(content.value);
                    }
                }, ['Fetch!']),
                Vue.h('div', { innerHTML: content.value }, [])
            ]);
        }
    }
};



const ul = r0();
const vnode = Vue.h('div', {}, [Vue.h(button), Vue.h(button2), ul]);
Vue.createApp({ render: () => vnode }).mount('#root');


// Unused
function randomize(elements) {
    for (var i = 0; i < elements.length; ++i) {
        const tmp = elements[i];
        const newIndex = Math.floor(Math.random() * elements.length);
        elements[i] = elements[newIndex];
        elements[newIndex] = tmp;
    }
}