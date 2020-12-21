class EasyHTTP {
    async update(url, data, type) {
        const response = await fetch(url, {
            method: type,
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(data)
        });
        return await response.json();
    };

    async post(url, data) {
        const response = await fetch(url, {
            method: "POST",
            body: data
        });
        return await response.json();
    };

    async get(url) {
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'Content-type': 'application/json'
            }
        });
        return await response.json();
    }
}